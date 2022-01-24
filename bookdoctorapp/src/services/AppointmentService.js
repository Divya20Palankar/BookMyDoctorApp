import axios from 'axios';

const APPOINTMENT_API_BASE_URL = "http://localhost:8080/api";

class AppointmentService {

    getAppointments(){
        return axios.get('http://localhost:8080/api/getAllAppointment');
    }

    createAppointment(appointment){
        return axios.post('http://localhost:8080/api/addAppointment', appointment);
    }

    getAppointmentById(appointmentId){
        return axios.get('http://localhost:8080/api/getAppointment/'+appointmentId);
    }

    updateAppointment(appointment){
        return axios.put('http://localhost:8080/api/updateAppointment',appointment);
    }

    deleteAppointment(appointmentId){
        return axios.delete('http://localhost:8080/api/deleteAppointment/'+ appointmentId);
    }
}

export default new AppointmentService()