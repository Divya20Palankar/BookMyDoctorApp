import axios from 'axios';

const FEEDBACK_FEED_BASE_URL = "http://localhost:8080/feed";

class FeedbackService {

    getFeedbacks(){
        return axios.get('http://localhost:8080/feed/getFeedbacks');           //DONE
    }

    createFeedback(feedback){
        return axios.post('http://localhost:8080/feed/addFeedback',feedback);         //DONE
    }

    getFeedbackById(feedbackId){
        return axios.get('http://localhost:8080/feed/getFeedback/'+ feedbackId);
    }

     updateFeedback(feedback){
         return axios.put('http://localhost:8080/feed/updateFeedback',feedback);
     }

     deleteFeedback(feedbackId){
         return axios.delete('http://localhost:8080/feed/deleteFeedback/'+ feedbackId);
     }
}

export default new FeedbackService()