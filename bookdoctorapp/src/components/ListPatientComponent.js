import React, { Component } from 'react'
import PatientService from '../services/PatientService'
import { Route , history, Link} from 'react-router-dom';
import {Table,TableBody,TableCell,TableContainer,TableHead,TableRow,Paper,Button,Typography,} from '@material-ui/core'

class ListPatientComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                patients: []
        }
        this.addPatient = this.addPatient.bind(this);
        this.editPatient = this.editPatient.bind(this);
        this.deletePatient = this.deletePatient.bind(this);
    }

    deletePatient(id){
        PatientService.deletePatient(id).then( res => {
            this.setState({patients: this.state.patients.filter(patient => patient.id !== id) });
            
        });
    }
    viewPatient(id){
        this.props.history.push(`/view-patient/${id}`);
    }
    editPatient(id){
        this.props.history.push(`/add-patient/${id}`);
    }

    componentDidMount(){
        PatientService.getPatients().then((res) => {
            this.setState({ patients: res.data});
        });
    }
    addPatient(){
        this.props.history.push('/add-patient/_add');
    }
    
    render() {
        return (
            <div className="bg">
                <div className="link">
                <Link to="/doctor">Click here to add doctor!</Link><br/>
                <Link to="/appointment">Click here to see appointments</Link><br></br>
                </div>
                <div className="table">
                  <Typography variant="h4" className="allign">
                 Patients List
                </Typography>
                <div className="button">
                  <Button className="button" color="primary" variant="contained"size="small" onClick={this.addPatient}>Add Patient</Button>
                  </div>
                 <TableContainer component={Paper} >
                 <Table sx={{ minWidth: 700 }} aria-label="customized table" >
                        <Table className="material-table"aria-label="simple table">
                             <TableHead className="tableHead">
                                <TableRow>
                                    
                                    <TableCell align="center">Name</TableCell>
                                    <TableCell align="center">Contact</TableCell>
                                    <TableCell align="center">Email</TableCell>
                                   
                                    <TableCell align="center">BloodGroup</TableCell>
                                    <TableCell align="center">Gender</TableCell>
                                    <TableCell align="center">Age</TableCell>
                                    <TableCell align="center">Address</TableCell>
                                    <TableCell align="center">Actions</TableCell>
                                </TableRow>
                            </TableHead>
                             <tbody>
                                {
                                    this.state.patients.map(
                                        patient => 
                                       <TableRow key = {patient.userId}>
                                                    
                                                  
                                                    <TableCell align="center">{patient.patientName}</TableCell>
                                                    <TableCell align="center">{patient.mobileNo}</TableCell>
                                                    <TableCell align="center">{patient.email}</TableCell>
                                                   
                                                    <TableCell align="center">{patient.bloodGroup}</TableCell>
                                                    <TableCell align="center">{patient.gender}</TableCell>
                                                    <TableCell align="center">{patient.age}</TableCell>
                                                    <TableCell align="center">{patient.address}</TableCell>
                                                    <TableCell align="center">
                                                        
                                                        <Button variant="contained"size="small" color="primary" onClick={ () => this.editPatient(patient.userId)}>Update</Button>
                                                        <Button variant="contained"size="small" color="secondary"  onClick={ () => this.deletePatient(patient.userId)}>Delete</Button>
                                                        <Button variant="contained"size="small" color="success" onClick={ () => this.viewPatient(patient.userId)}>View</Button>
                                                    </TableCell>

                                                </TableRow>
                                    ) }
                            </tbody> 
                         
                 </Table>
                 </Table>
                </TableContainer></div>
                </div>
        )
    }
}

export default ListPatientComponent
