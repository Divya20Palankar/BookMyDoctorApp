import React from "react";
import {BrowserRouter as Router, Route, Routes, Switch} from 'react-router-dom'
import Navbar from "./components/HeaderComponent";
import Footer from "./components/FooterComponent";
import Home from "./components/HomeComponent";
import about from "./components/AboutComponent";
import login from "./components/LoginComponent";

import ListPatientComponent from "./components/ListPatientComponent";
import CreatePatientComponent from "./components/CreatePatientComponent";
import ViewPatientComponent from "./components/ViewPatientComponent";
import ListPatient1Component from "./components/ListPatients1Component";

import CreateDoctorComponent from "./components/CreateDoctorComponent";
import ViewDoctorComponent from "./components/ViewDoctorComponent";
import ListDoctorComponent from "./components/ListDoctorComponent";
import ListDoctor1Component from "./components/ListDoctor1Component";

import CreateAppointmentComponent from './components/CreateAppointmentComponent';
import ViewAppointmentComponent from './components/ViewAppointmentComponent';
import ListAppointmentComponent from './components/ListAppointmentComponent';
import ListAppointmentsComponent from "./components/ListApointmentsComponent";

import ViewFeedbackComponent from "./components/ViewFeedbackComponent";
import ListFeedbackComponent from "./components/ListFeedbackComponent";
import CreateFeedbackComponent from "./components/CreateFeedbackComponent";

function App() {
  return (
     <div>
     <Router>
           <Navbar />
             <div className="container">
                <Switch> 
                  <Route path = "/" exact component={Home}></Route> 
                  <Route path = "/about" exact component={about}></Route>
                  <Route path = "/login" exact component={login}></Route>

                  <Route path = "/admin" exact component={ListPatientComponent}></Route> 
                  <Route path = "/getPatients" component={ListPatientComponent}></Route>
                  <Route path = "/add-patient/:id" component={CreatePatientComponent}></Route>
                  <Route path = "/view-patient/:id" component={ViewPatientComponent} ></Route>

                  <Route path = "/add-doctor/:id" component={CreateDoctorComponent}></Route>
                  <Route path = "/view-doctor/:id" component={ViewDoctorComponent} ></Route>
                  <Route path = "/getDoctorList" component={ListDoctorComponent}></Route>
                  <Route path = "/doctorLogin" exact component={ListPatient1Component}></Route> 
                  
                  <Route path = "/patient" exact component={ListDoctor1Component}></Route> 
                  <Route path = "/appointment" exact component={ListAppointmentsComponent}></Route> 
                  <Route path = "/appointment1" exact component={ListAppointmentComponent}></Route> 
                  <Route path = "/getAppointments" component={ListAppointmentComponent}></Route>
                  <Route path = "/add-appointment/:id" component={CreateAppointmentComponent}></Route>
                  <Route path = "/view-appointment/:id" component={ViewAppointmentComponent} ></Route>
                  <Route path = "/doctor" exact component={ListDoctorComponent}></Route> 
                  <Route path = "/appointment" component={ListAppointmentComponent}></Route>
                  <Route path = "/appointment2" component={ListAppointmentsComponent}></Route>

                  <Route path = "/feedback" exact component={ListFeedbackComponent}></Route> 
                  <Route path = "/getFeedBackList" component={ListFeedbackComponent}></Route>
                  <Route path = "/add-feedback/:id" component={CreateFeedbackComponent}></Route>
                  <Route path = "/view-feedback/:id" component={ViewFeedbackComponent} ></Route>
                  
                </Switch>
             </div>
           <Footer />
     </Router>
 </div>
  );
}
export default App;