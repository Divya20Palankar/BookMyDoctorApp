import React, { Component } from 'react'
import AppointmentService from '../services/AppointmentService';
import { Grid,Button,FormGroup } from '@material-ui/core';
import TextField from '@material-ui/core/TextField';

class CreateAppointmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            appointmentId: this.props.match.params.id,
            appointmentDate: '',
            appointmentStatus: '',
            formErrors: {} 
        }
      
        this.changeAppointmentDateHandler = this.changeAppointmentDateHandler.bind(this);
        this.changeAppointmentStatusHandler = this.changeAppointmentStatusHandler.bind(this);
        this.saveOrUpdateAppointment = this.saveOrUpdateAppointment.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            AppointmentService.getAppointmentById(this.state.appointmentId).then( (res) =>{
                let appointment = res.data;
                this.setState({
                    appointmentDate: appointment.appointmentDate,
                    appointmentStatus : appointment.appointmentStatus
                 
                });
            });
        }        
    }
    saveOrUpdateAppointment = (e) => {
        e.preventDefault();
        if (this.handleFormValidation()) {  
        let appointment = {appointmentDate: this.state.appointmentDate, appointmentStatus: this.state.appointmentStatus};
        let appointment1 = {appointmentId:this.state.appointmentId,appointmentDate: this.state.appointmentDate, appointmentStatus: this.state.appointmentStatus};
        console.log('appointment => ' + JSON.stringify(appointment1));

        // step 5
        if(this.state.appointmentId === '_add'){
            AppointmentService.createAppointment(appointment).then(res =>{
                this.props.history.push('/getAppointments');
                alert("Added successfully..")
            });
        }else{
            AppointmentService.updateAppointment(appointment1).then( res => {
                this.props.history.push('/getAppointments');
                alert("Updated successfully..")
            });
        }
    }
    }
    handleFormValidation() {    
        const { appointmentDate,appointmentStatus } = this.state;    
        let formErrors = {};    
        let formIsValid = true;    
       
    
         
        if (!appointmentDate) {    
            formIsValid = false;    
            formErrors["appointmentDateErr"] = "Date is required.";    
        }    
        else {    
            var pattern = /^(0[1-9]|1[0-9]|2[0-9]|3[0-1])\/(0[1-9]|1[0-2])\/([0-9]{4})$/;    
            if (!pattern.test(appointmentDate)) {    
                formIsValid = false;    
                formErrors["appointmentDateErr"] = "Invalid date ,Ex:23/12/2021";    
            }    
        }    
    
        if (!appointmentStatus) {    
            formIsValid = false;    
            formErrors["appointmentStatusErr"] = "Status is required.";    
        }    
          
    
        this.setState({ formErrors: formErrors });    
        return formIsValid;    
    }
    
    changeAppointmentDateHandler= (event) => {
        this.setState({appointmentDate: event.target.value});
    }

    changeAppointmentStatusHandler= (event) => {
        this.setState({appointmentStatus: event.target.value});
    }


    cancel(){
        this.props.history.push('/getAppointments');
    }

    getTitle(){
        if(this.state.appointmentId === '_add'){
            return <h3 className="text-center">Add Appointment</h3>
        }else{
            return <h3 className="text-center">Update Appointment</h3>
        }
       // const classes = useStyles();
    }
    render() {
        const { appointmentDateErr, appointmentStatusErr} = this.state.formErrors;    

        return (
            <div className="adding">
            <div className="heading">
            <div className="update" >
            {
                this.getTitle()
            }</div>
            <form>
            <Grid  className="create">
                <div className="box">
                    <div className='boxes'>
                <Grid container>
                    <Grid item xs={12}>
                        <TextField name="appointmentId" value={this.state.appointmentId} label={"Id"} />
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="appointmentDate" 
                            onChange={this.changeAppointmentDateHandler} 
                            value={this.state.appointmentDate} 
                            label={"Appointment Date"}  
                            validators={['required']}
                            errorMessages={['this field is required']}
                            className={appointmentDateErr ? ' showError' : ''} 
                            />
                            {appointmentDateErr &&    
                                    <div style={{ color: "red", paddingBottom: 10 }}>{appointmentDateErr}</div>    
                                }
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="appointmentStatus" 
                        value={this.state.appointmentStatus} 
                        onChange={this.changeAppointmentStatusHandler} 
                        label={"Appointment For"} 
                        className={appointmentStatusErr ? ' showError' : ''} 
                        />
                        {appointmentStatusErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{appointmentStatusErr}</div>    
                            }
                    </Grid> <br></br>
                    <div  className="save">
                        <Button  variant="contained"size="small" color="primary"onClick={this.saveOrUpdateAppointment}>Save</Button>
                    </div>
                    <div className="cancel">
                        <Button  variant="contained"size="small"  color="secondary" onClick={this.cancel.bind(this)}>Cancel</Button>
                    </div>
                </Grid>
                </div>
                </div>
            </Grid>
        </form>
        </div>
        </div>
        )
    }
}

export default CreateAppointmentComponent
