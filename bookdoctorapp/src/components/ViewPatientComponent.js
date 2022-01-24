import React, { Component } from 'react'
import PatientService from '../services/PatientService'
import {Typography} from '@material-ui/core';

class ViewPatientComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            patient: {}
        }
    }

    componentDidMount(){
        PatientService.getPatientById(this.state.id).then( res => {
            this.setState({patient: res.data});
           
        })
        
    }

    render() {
        return (
            <div className="views">
                    <Typography variant="h4" className="allign">
                        View Patient Details
                    </Typography>
                        <div className="view">
                                <div> 
                                Name: {this.state.patient.patientName}
                                </div>
                                <div>
                                Mobile No: {this.state.patient.mobileNo}
                                </div>
                                <div>
                                Email ID: {this.state.patient.email}
                                </div>
                             <div>
                             Password: {this.state.patient.password}
                             </div>
                             <div>
                                Blood Group: 
                                 {this.state.patient.bloodGroup}
                                 </div>
                          
                                <div>
                                Gender: {this.state.patient.gender}
                                </div>
                           
                                <div> 
                                Age: {this.state.patient.age}
                                </div>
                                <div>
                                Address: 
                                {this.state.patient.address}</div>
                            
                        </div>
                    </div>
        )
    }
}

export default ViewPatientComponent
