import React, { Component } from 'react'
import DoctorService from '../services/DoctorService'
import {Typography} from '@material-ui/core';

class ViewDoctorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            doctor: {}
        }
    }

    componentDidMount(){
        DoctorService.getDoctorById(this.state.id).then( res => {
            this.setState({doctor: res.data});
           
        })
        
    }

    render() {
        return (
            <div className="views">
                    <Typography variant="h4" className="allign">
                        View Doctor Details
                    </Typography>
                        <div className="view">
                               <div> 
                               Doctor Name:{this.state.doctor.doctorName}
                               </div>
                           <div> 
                           Speciality : {this.state.doctor.speciality}
                           </div>
                           <div>
                                Location:
                                 {this.state.doctor.location}
                                 </div>
                            
                                <div>
                                Hospital Name: {this.state.doctor.hospitalName}</div>
                             
                                <div> 
                                MobileNo : {this.state.doctor.mobileNo}
                                </div>
                           
                                <div> 
                                Email: {this.state.doctor.email}</div>
                           
                                <div> 
                                Age:{this.state.doctor.password}</div>
                             
                                <div>
                                Address:{this.state.doctor.chargedPerVisit}</div>
                            
                        </div>
                    </div>
        )
    }
}

export default ViewDoctorComponent
