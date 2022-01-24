import React, { Component } from 'react'
import FeedbackService from '../services/FeedBackService';
import { Grid,Button } from '@material-ui/core';
import TextField from '@material-ui/core/TextField';

class CreateFeedbackComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            feedbackId: this.props.match.params.id,
            rating: '',
	        feedback_details: '',
            formErrors: {} 
	        
        }
       // this.changefeedbackIdHandler = this.changefeedbackIdHandler.bind(this);
        this.changeRatingHandler = this.changeRatingHandler.bind(this);
        this.changeFeedback_DetailsHandler=this.changeFeedback_DetailsHandler.bind(this);
        this.saveOrUpdateFeedback = this.saveOrUpdateFeedback.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            FeedbackService.getFeedbackById(this.state.feedbackId).then( (res) =>{
                let feedback = res.data;
                this.setState({rating: feedback.rating,
                    feedback_details: feedback.feedback_details,
                });
            });
        }        
    }
    saveOrUpdateFeedback = (e) => {
        e.preventDefault();
        if (this.handleFormValidation()) {  
        let feedback = {rating: this.state.rating, feedback_details: this.state.feedback_details};
        let feedback1 = {feedbackId:this.state.feedbackId,rating: this.state.rating, feedback_details: this.state.feedback_details};
        console.log('feedback => ' + JSON.stringify(feedback1));

        // step 5
        if(this.state.feedbackId === '_add'){
            FeedbackService.createFeedback(feedback).then(res =>{
                this.props.history.push('/getFeedbacks');
                alert("Added successfully...")
            });
        }else{
            FeedbackService.updateFeedback(feedback1).then( res => {
                this.props.history.push('/getFeedbacks');
                alert("Updated successfully...")
            });
        }
    }
    }
    
    handleFormValidation() {    
        const { rating,feedback_details } = this.state;    
        let formErrors = {};    
        let formIsValid = true;    
          
    
        if (!rating) {    
            formIsValid = false;    
            formErrors["ratingErr"] = "Status is required.";    
        }  
        if (!feedback_details) {    
            formIsValid = false;    
            formErrors["feedback_detailsErr"] = "Status is required.";    
        }    
          
    
        this.setState({ formErrors: formErrors });    
        return formIsValid;    
    }
    changeRatingHandler= (event) => {
        this.setState({rating: event.target.value});
    }

    changeFeedback_DetailsHandler= (event) => {
        this.setState({feedback_details: event.target.value});
    }

  

    cancel(){
        this.props.history.push('/getFeedbacks');
    }

    getTitle(){
        if(this.state.feedbackId === '_add'){
            return <h3 className="text-center">Add FeedBack</h3>
        }else{
            return <h3 className="text-center">Update FeedBack</h3>
        }
    }
    render() {
        const { ratingErr, feedback_detailsErr} = this.state.formErrors;    

        return (
            <div className="adding">
            <div className="heading">
            <div className="update">
            {
                this.getTitle()
            }</div>
            <form>
            <Grid  className="create">
                <div className='box'>
                    <div className='boxes'>
                   
                <Grid container>
                    <Grid item xs={12}>
                        <TextField name="feedbackId" value={this.state.feedbackId} label={"FeedBack Id"} />
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="rating" onChange={this.changeRatingHandler} 
                        value={this.state.rating} label={"Rating"} 
                        className={ratingErr ? ' showError' : ''} 
                            />
                            {ratingErr &&    
                                    <div style={{ color: "red", paddingBottom: 10 }}>{ratingErr}</div>    
                                }
                    </Grid> 
                    <Grid item xs={12}>
                        <TextField name="feedback_details" value={this.state.feedback_details} 
                        onChange={this.changeFeedback_DetailsHandler} label={"Feedback Details"} 
                        className={feedback_detailsErr ? ' showError' : ''} 
                            />
                            {feedback_detailsErr &&    
                                    <div style={{ color: "red", paddingBottom: 10 }}>{feedback_detailsErr}</div>    
                                }
                    </Grid> 
                    <div className="save">
                    <Button variant="contained"size="small" color="primary"  onClick={this.saveOrUpdateFeedback}>Save</Button>
                    </div>
                    <div className="cancel">
                    <Button variant="contained"size="small" color="secondary" onClick={this.cancel.bind(this)}>Cancel</Button>
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
         
export default CreateFeedbackComponent