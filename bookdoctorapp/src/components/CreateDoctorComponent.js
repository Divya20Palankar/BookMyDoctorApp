import React, { Component } from 'react'
import DoctorService from '../services/DoctorService';
import { Grid,Button } from '@material-ui/core';
import TextField from '@material-ui/core/TextField';

class CreateDoctorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            userId: this.props.match.params.id,
            doctorName: '',
	        speciality: '',
            location: '',
            hospitalName: '',
            mobileNo: '',
            email: '',
            password: '',
            chargedPerVisit: '',
            formErrors: {} 
        }
        this.changeDoctorNameHandler = this.changeDoctorNameHandler.bind(this);
        this.changemobileNoHandler = this.changemobileNoHandler.bind(this);
        this.changeemailHandler = this.changeemailHandler.bind(this);
        this.changepasswordHandler=this.changepasswordHandler.bind(this);
        this.changespecialityHandler = this.changespecialityHandler.bind(this);
        this.changelocationHandler=this.changelocationHandler.bind(this);
        this.changehospitalNameHandler=this.changehospitalNameHandler.bind(this);
        this.changechargedPerVisitHandler=this.changechargedPerVisitHandler.bind(this);
        this.saveOrUpdateDoctor = this.saveOrUpdateDoctor.bind(this);

    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DoctorService.getDoctorById(this.state.userId).then( (res) =>{
                let doctor = res.data;
                this.setState({doctorName: doctor.doctorName,
                    mobileNo:doctor.mobileNo,
                    email:doctor.email,
                    password:doctor.password,
                    speciality: doctor.speciality,
                    location : doctor.location,
                    hospitalName:doctor.hospitalName,
                    chargedPerVisit:doctor.chargedPerVisit
                });
            });
        }        
    }
    saveOrUpdateDoctor = (e) => {
        e.preventDefault();
        if (this.handleFormValidation()) {  
        let doctor = {doctorName: this.state.doctorName,mobileNo:this.state.mobileNo,email:this.state.email,password:this.state.password, speciality: this.state.speciality, location: this.state.location,hospitalName:this.state.hospitalName,chargedPerVisit:this.state.chargedPerVisit};
        let doctor1 = {userId:this.state.userId,doctorName: this.state.doctorName,mobileNo:this.state.mobileNo,email:this.state.email,password:this.state.password, speciality: this.state.speciality, location: this.state.location,hospitalName:this.state.hospitalName,chargedPerVisit:this.state.chargedPerVisit};
        console.log('doctor => ' + JSON.stringify(doctor1));

        // step 5
        if(this.state.userId === '_add'){
            DoctorService.createDoctor(doctor).then(res =>{
                this.props.history.push('/getDoctorList');
                alert("Added successfully..")
            });
        }else{
            DoctorService.updateDoctor(doctor1).then( res => {
                this.props.history.push('/getDoctorList');
                alert("Updated successfully..")
            });
        }
    }
    }
    
    handleFormValidation() {    
        const { doctorName, email, mobileNo ,password,speciality,location,hospitalName,chargedPerVisit } = this.state;    
        let formErrors = {};    
        let formIsValid = true;    
    
        //name     
        if (!doctorName) {    
            formIsValid = false;    
            formErrors["doctorNameErr"] = "Name is required.";    
        }    
    
        //Email    
        if (!email) {    
            formIsValid = false;    
            formErrors["emailErr"] = "Email id is required.";    
        }    
        else if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))) {    
    
            formIsValid = false;    
            formErrors["emailErr"] = "Invalid email id.";    
        }      
       
    
        //Phone number    
        if (!mobileNo) {    
            formIsValid = false;    
            formErrors["mobileNoErr"] = "Phone number is required.";    
        }    
        else {    
            var mobPattern = /^(?:(?:\\+|0{0,2})91(\s*[\\-]\s*)?|[0]?)?[789]\d{9}$/;    
            if (!mobPattern.test(mobileNo)) {    
                formIsValid = false;    
                formErrors["mobileNoErr"] = "Invalid phone number.";    
            }    
        } 

        if (!password) {    
            formIsValid = false;    
            formErrors["passwordErr"] = "Phone number is required.";    
        }    
        else {    
            var passPattern =  /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;    
            if (!passPattern.test(password)) {    
                formIsValid = false;    
                formErrors["passwordErr"] = "Must Contain 8 Characters, One Uppercase, One Lowercase, One Number and One Special Case Character.";    
            }    
        }
        
        if (!speciality) {    
            formIsValid = false;    
            formErrors["specialityErr"] = "Specialization is required.";    
        }

        if (!location) {    
            formIsValid = false;    
            formErrors["locationErr"] = "Location is required.";    
        }
        
        if (!hospitalName) {    
            formIsValid = false;    
            formErrors["hospitalNameErr"] = "Hospital Name is required.";    
        }  
        if (!chargedPerVisit) {    
            formIsValid = false;    
            formErrors["chargedPerVisitErr"] = "chargedPerVisit is required.";    
        } 
       
    
        this.setState({ formErrors: formErrors });    
        return formIsValid;    
    } 
     

    changeDoctorNameHandler= (event) => {
        this.setState({doctorName: event.target.value});
    }


    changemobileNoHandler= (event) => {
        this.setState({mobileNo: event.target.value});
    }

    changeemailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    changepasswordHandler= (event) => {
        this.setState({password: event.target.value});
    }

    changespecialityHandler= (event) => {
        this.setState({speciality: event.target.value});
    }

    changelocationHandler= (event) => {
        this.setState({location: event.target.value});
    }

    changehospitalNameHandler= (event) => {
        this.setState({hospitalName: event.target.value});
    }

    changechargedPerVisitHandler= (event) => {
        this.setState({chargedPerVisit: event.target.value});
    }

    cancel(){
        this.props.history.push('/getDoctorList');
    }

    getTitle(){
        if(this.state.userId === '_add'){
            return <h3 className="text-center">Add Doctor</h3>
        }else{
            return <h3 className="text-center">Update Doctor</h3>
        }
    }
    render() {
        const { doctorNameErr, emailErr, mobileNoErr ,passwordErr, specialityErr,locationErr,hospitalNameErr,chargedPerVisitErr} = this.state.formErrors;    
        return (
            <div className="adding">
            <div className="heading">
            <div className="update">
            {
                this.getTitle()
            }</div>
            <form>
            <Grid  className="create">
                <div className='doctor'>
                    <div className='doctors'>

                <Grid container>
                    <Grid item xs={12}>
                        <TextField name="userId" value={this.state.userId} label={"Id"} />
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="doctorName" onChange={this.changeDoctorNameHandler} 
                        value={this.state.doctorName} label={"Doctor Name"} 
                        className={doctorNameErr ? ' showError' : ''} 
                        />
                        {doctorNameErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{doctorNameErr}</div>    
                            }

                    </Grid>
                    <Grid item xs={12}>
                        <TextField name="mobileNo" value={this.state.mobileNo} 
                        onChange={this.changemobileNoHandler} label={"Mobile No"}
                        className={mobileNoErr ? ' showError' : ''} 
                        />
                        {mobileNoErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{mobileNoErr}</div>    
                            }

                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="email" value={this.state.email} onChange={this.changeemailHandler} 
                        label={" Email"} 
                        className={emailErr ? ' showError' : ''} 
                        />
                        {emailErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{emailErr}</div>    
                            }

                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="password" value={this.state.password} 
                        onChange={this.changepasswordHandler} label={"password"} 
                        className={passwordErr ? ' showError' : ''} 
                        />
                        {passwordErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{passwordErr}</div>    
                            }

                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="speciality" value={this.state.speciality}
                         onChange={this.changespecialityHandler} label={"Sprecialization"} 
                         className={specialityErr ? ' showError' : ''} 
                        />
                        {specialityErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{specialityErr}</div>    
                            }

                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="location" value={this.state.location} 
                        onChange={this.changelocationHandler} label={"Location "} 
                        className={locationErr ? ' showError' : ''} 
                        />
                        {locationErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{locationErr}</div>    
                            }

                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="hospitalName" value={this.state.hospitalName} 
                        onChange={this.changehospitalNameHandler} label={"Hospital Name"} 
                        className={hospitalNameErr ? ' showError' : ''} 
                        />
                        {hospitalNameErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{hospitalNameErr}</div>    
                            }

                    </Grid>
                    <Grid item xs={12}>
                        <TextField name="chargedPerVisit"  value={this.state.chargedPerVisit} 
                        onChange={this.changechargedPerVisitHandler} label={"Charge per visit"} 
                        className={chargedPerVisitErr ? ' showError' : ''} 
                        />
                        {chargedPerVisitErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{chargedPerVisitErr}</div>    
                            }

                    </Grid>      
                    <div  className="save">
                    <Button variant="contained" color="primary" size="small" onClick={this.saveOrUpdateDoctor}>Save</Button>
                    </div>
                    <div className="cancel">
                    <Button variant="contained" color="secondary" size="small" onClick={this.cancel.bind(this)}>Cancel</Button>
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
         
export default CreateDoctorComponent
