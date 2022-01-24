import axios from 'axios';

const DOCTOR_DOC_BASE_URL = "http://localhost:8080/doc";

class DoctorService {

    getDoctors(){
        return axios.get('http://localhost:8080/doc/getDoctorList');
    }

    createDoctor(doctor){
        return axios.post('http://localhost:8080/doc/addDoctor', doctor);
    }

    getDoctorById(userId){
        return axios.get('http://localhost:8080/doc/getDoctor/'+userId);
    }

    updateDoctor(doctor){
        return axios.put('http://localhost:8080/doc/updateDoctorProfile',doctor);
    }

    removeDoctor(userId){
        return axios.delete('http://localhost:8080/doc/removeDoctor/'+ userId);
    }
}

export default new DoctorService()