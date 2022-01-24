import axios from 'axios';

const PATIENT_API_BASE_URL = "http://localhost:8080/api";

class PatientService {

    getPatients(){
        return axios.get('http://localhost:8080/api/getPatients');
    }

    createPatient(patient){
        return axios.post('http://localhost:8080/api/addPatient', patient);
    }

    getPatientById(userId){
        return axios.get('http://localhost:8080/api/getPatient/'+userId);
    }

    updatePatient(patient){
        return axios.put('http://localhost:8080/api/updatePatient',patient);
    }

    deletePatient(userId){
        return axios.delete('http://localhost:8080/api/deletePatient/'+ userId);
    }
}

export default new PatientService()