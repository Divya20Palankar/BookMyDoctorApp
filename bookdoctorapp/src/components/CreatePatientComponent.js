import React, { Component } from 'react'
import PatientService from '../services/PatientService';
import { Grid,Button, FormControl } from '@material-ui/core';
import TextField from '@material-ui/core/TextField';

class CreatePatientComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            userId: this.props.match.params.id,
            patientName: '',
	        mobileNo: '',
	         email: '',
	       password: '',
	 bloodGroup: '',
	 gender: '',
	 age: '',
	 address: '',
     formErrors: {} 
        }
        this.changePatientNameHandler = this.changePatientNameHandler.bind(this);
        this.changeMobileNoHandler = this.changeMobileNoHandler.bind(this);
        this.changeEmailHandler=this.changeEmailHandler.bind(this);
        this.changePasswordHandler=this.changePasswordHandler.bind(this);
        this.changeBloodGroupHandler = this.changeBloodGroupHandler.bind(this);
        this.changeGenderHandler = this.changeGenderHandler.bind(this);
        this.changeAgeHandler=this.changeAgeHandler.bind(this);
        this.changeAddressHandler=this.changeAddressHandler.bind(this);
        this.saveOrUpdatePatient = this.saveOrUpdatePatient.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PatientService.getPatientById(this.state.userId).then( (res) =>{
                let patient = res.data;
                this.setState({patientName: patient.patientName,
                    mobileNo: patient.mobileNo,
                    email : patient.email,
                    password:patient.password,
                    bloodGroup:patient.bloodGroup,
                    gender:patient.gender,
                    age:patient.age,
                    address:patient.address
                });
            });
        }        
    }
    saveOrUpdatePatient = (e) => {
        e.preventDefault();
        if (this.handleFormValidation()) {      
        let patient = {patientName: this.state.patientName, mobileNo: this.state.mobileNo, email: this.state.email,password:this.state.password,bloodGroup:this.state.bloodGroup,gender:this.state.gender,age:this.state.age,address:this.state.address};
        let patient1 = {userId:this.state.userId,patientName: this.state.patientName, mobileNo: this.state.mobileNo, email: this.state.email,password:this.state.password,bloodGroup:this.state.bloodGroup,gender:this.state.gender,age:this.state.age,address:this.state.address};
        console.log('patient => ' + JSON.stringify(patient1));
        
        // step 5
        if(this.state.userId === '_add'){
            PatientService.createPatient(patient).then(res =>{
                this.props.history.push('/getPatients');
                alert("Added successfully...");
            });
        }else{
            PatientService.updatePatient(patient1).then( res => {
                this.props.history.push('/getPatients');
                alert("Updated successfully...")
            });
        }
    }
    }

    handleFormValidation() {    
        const { patientName, email, mobileNo ,password,age,bloodGroup,address,gender } = this.state;    
        let formErrors = {};    
        let formIsValid = true;    
    
        //name     
        if (!patientName) {    
            formIsValid = false;    
            formErrors["patientNameErr"] = "Name is required.";    
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
            formErrors["passwordErr"] = "Password is required.";    
        }    
        else {    
            var passPattern =  /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;    
            if (!passPattern.test(password)) {    
                formIsValid = false;    
                formErrors["passwordErr"] = "Must Contain 8 Characters, One Uppercase, One Lowercase, One Number and One Special Case Character.";    
            }    
        }
        
        if (!bloodGroup) {    
            formIsValid = false;    
            formErrors["bloodGroupErr"] = "Blood group is required.";    
        }

        if (!age) {    
            formIsValid = false;    
            formErrors["ageErr"] = "Age is required.";    
        }    
        else {    
            var agePattern = /^[1-9]?[0-9]{1}$|^100$/;    
            if (!agePattern.test(age)) {    
                formIsValid = false;    
                formErrors["ageErr"] = "Invalid age.";    
            }    
        }
        if (!gender) {    
            formIsValid = false;    
            formErrors["genderErr"] = "Gender is required.";    
        }  
        if (!address) {    
            formIsValid = false;    
            formErrors["addressErr"] = "Address is required.";    
        } 
       
    
        this.setState({ formErrors: formErrors });    
        return formIsValid;    
    } 
     
    
    
    changePatientNameHandler= (event) => {
        this.setState({patientName: event.target.value});
    }

    changeMobileNoHandler= (event) => {
        this.setState({mobileNo: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    changePasswordHandler= (event) => {
        this.setState({password: event.target.value});
    }

    changeBloodGroupHandler= (event) => {
        this.setState({bloodGroup: event.target.value});
    }

    changeGenderHandler= (event) => {
        this.setState({gender: event.target.value});
    }

    changeAgeHandler= (event) => {
        this.setState({age: event.target.value});
    }

    changeAddressHandler= (event) => {
        this.setState({address: event.target.value});
    }

    cancel(){
        this.props.history.push('/getPatients');
    }

    getTitle(){
        if(this.state.userId === '_add'){
            return <h3 className="text-center">Add Patient</h3>
        }else{
            return <h3 className="text-center">Update Patient</h3>
        }
    }
    render() {
        const { patientNameErr, emailErr, mobileNoErr ,passwordErr, ageErr,genderErr,bloodGroupErr,addressErr} = this.state.formErrors;    
        return (
            <div className="adding">
            <div className="heading">
            <div className="update">
            {
                this.getTitle()
            }</div>
            <FormControl>
            <form>
            <Grid  className="create">
                <div className="doctor">
                    <div className='doctors'>
                <Grid container>
                    <Grid item xs={12}>
                        <TextField name="userId" value={this.state.userId} label={"Id"} />
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="patientName" required onChange={this.changePatientNameHandler} 
                        value={this.state.patientName} label={"Patient Name"} 
                        className={patientNameErr ? ' showError' : ''} 
                        />
                        {patientNameErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{patientNameErr}</div>    
                            }

                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="mobileNo" required value={this.state.mobileNo} 
                        onChange={this.changeMobileNoHandler} label={"Mobile No"} 
                        className={mobileNoErr ? ' showError' : ''}/>
                        {mobileNoErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{mobileNoErr}</div>    
                            } 
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="email" required value={this.state.email} onChange={this.changeEmailHandler}
                         label={"Email Id"} className={emailErr ? ' showError' : ''} />
                         {emailErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{emailErr}</div>    
                            } 
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="password" value={this.state.password} 
                        onChange={this.changePasswordHandler} label={"Password"} 
                        className={passwordErr ? ' showError' : ''}/>
                         {passwordErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{passwordErr}</div>    
                            } 
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="bloodGroup" value={this.state.bloodGroup}
                         onChange={this.changeBloodGroupHandler} label={"blood Group"} 
                         className={bloodGroupErr ? ' showError' : ''}/>
                         {bloodGroupErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{bloodGroupErr}</div>    
                            } 
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="gender" value={this.state.gender} onChange={this.changeGenderHandler} 
                        label={" Gender"} 
                        className={genderErr ? ' showError' : ''}/>
                         {genderErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{genderErr}</div>    
                            } 
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="age" value={this.state.age} onChange={this.changeAgeHandler} 
                        label={"Age"} 
                        className={ageErr ? ' showError' : ''}/>
                         {ageErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{ageErr}</div>    
                            } 
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="address"  value={this.state.address} 
                        onChange={this.changeAddressHandler} label={"Address"} 
                        className={addressErr ? ' showError' : ''}/>
                         {addressErr &&    
                                <div style={{ color: "red", paddingBottom: 10 }}>{addressErr}</div>    
                            } 
                    </Grid>      
                    <div className="save">
                   
                    <Button variant="contained"size="small" color="primary" onClick={this.saveOrUpdatePatient}>Save</Button>
                    </div>
                    <div className="cancel">
                    <Button variant="contained"size="small" color="secondary" onClick={this.cancel.bind(this)}>Cancel</Button>
                    </div>
                </Grid>
                </div>
                </div>
            </Grid>
        </form>
        </FormControl>
        </div>
        </div>
         )
    }
}
         
export default CreatePatientComponent
