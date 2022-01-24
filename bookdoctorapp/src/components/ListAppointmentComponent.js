import React, { Component } from 'react'
import AppointmentService from '../services/AppointmentService'
import { Route , history} from 'react-router-dom';
import {Table,TableBody,TableCell,TableContainer,TableHead,TableRow,Paper,Button,Typography,} from '@material-ui/core'
import { Link } from 'react-router-dom/cjs/react-router-dom.min';

class ListAppointmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                appointments: []
        }
        this.addAppointment = this.addAppointment.bind(this);
        this.editAppointment = this.editAppointment.bind(this);
        this.deleteAppointment = this.deleteAppointment.bind(this);
    }

    deleteAppointment(id){
        AppointmentService.deleteAppointment(id).then( res => {
            this.setState({appointments: this.state.appointments.filter(appointment => appointment.id !== id) });
            
        });
    }
    viewAppointment(id){
        this.props.history.push(`/view-appointment/${id}`);
    }
    editAppointment(id){
        this.props.history.push(`/add-appointment/${id}`);
    }

    componentDidMount(){
        AppointmentService.getAppointments().then((res) => {
            this.setState({ appointments: res.data});
        });
    }
    addAppointment(){
        this.props.history.push('/add-appointment/_add');
    }
    render() {
        return (
           
            <div className="bg">
            
           <Typography variant="h4" className="allign">
           Appointments List
          </Typography>
          <div className="button">
                  <Button className="button" color="primary" variant="contained"size="small" onClick={this.addAppointment}>Add Appointment</Button>
                  </div>
          <div className="table1">
           <TableContainer component={Paper}>
                  <Table className="material-table"aria-label="simple table">
                       <TableHead className="tableHead">
                          <TableRow>
     
                              <TableCell align="center">Appointment Date</TableCell>
                              <TableCell align="center">Appointment For</TableCell>
                             
                          </TableRow>
                      </TableHead>
                       <tbody>
                          {
                              this.state.appointments.map(
                                  appointment => 
                                 <TableRow>
                                              
                                      
                                              <TableCell align="center">{appointment.appointmentDate}</TableCell>
                                              <TableCell align="center">{appointment.appointmentStatus}</TableCell>
                                           
                                          </TableRow>
                              ) }
                      </tbody> 
                   
           </Table>
          </TableContainer></div>
          </div>
        )
    }
}

export default ListAppointmentComponent
