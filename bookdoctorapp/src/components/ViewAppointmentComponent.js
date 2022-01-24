import React, { Component } from 'react'
import AppointmentService from '../services/AppointmentService'
import {Typography} from '@material-ui/core';

class ViewAppointmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            appointment: {}
        }
    }

    componentDidMount(){
        AppointmentService.getAppointmentById(this.state.id).then( res => {
            this.setState({appointment: res.data});
           
        })
        
    }

    render() {
        return (
            <div className="views">
            <Typography variant="h4">
                View Appointment Details
            </Typography>
                <div className="view">
                    <Typography variant="h6">
                        Appointment Date:
                        <div> {this.state.appointment.appointmentDate}</div>
                    </Typography>
                
                    <Typography variant="h6">
                        Appointment For:
                        <div> {this.state.appointment.appointmentStatus}</div>
                    </Typography>
                    <Typography variant="h6">
                        Appointment Status:
                       
                    </Typography>
                    <div className="aprove">
                    <Typography variant="h6">
                        Aproved Successfully...
                    </Typography>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAppointmentComponent
