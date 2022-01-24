import React, { Component } from 'react'
import AppointmentService from '../services/AppointmentService'
import { Route , history} from 'react-router-dom';
import {Table,TableBody,TableCell,TableContainer,TableHead,TableRow,Paper,Button,Typography,} from '@material-ui/core'
import { Link } from 'react-router-dom/cjs/react-router-dom.min';

class ListAppointment extends Component {
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
          <div className="table">
           <TableContainer component={Paper} >
                  <Table className="material-table"aria-label="simple table">
                       <TableHead className="tableHead">
                          <TableRow>
                             
                              <TableCell align="center">Appointment Date</TableCell>
                              <TableCell align="center">Appointment For</TableCell>
                              <TableCell align="center">Action</TableCell>
                          </TableRow>
                      </TableHead>
                       <tbody>
                          {
                              this.state.appointments.map(
                                  appointment => 
                                 <TableRow>
                                              
                                              
                                              <TableCell align="center">{appointment.appointmentDate}</TableCell>
                                              <TableCell align="center">{appointment.appointmentStatus}</TableCell>
                                              
                                              <TableCell align="center">
                                                  
                                                  <Button variant="contained" color="secondary" size="small" onClick={ () => this.deleteAppointment(appointment.appointmentId)}>Cancel</Button>
</TableCell>

                                          </TableRow>
                              ) }
                      </tbody> 
                   
           </Table>
          </TableContainer></div>
          </div>
  
        )
    }
}

export default ListAppointment
