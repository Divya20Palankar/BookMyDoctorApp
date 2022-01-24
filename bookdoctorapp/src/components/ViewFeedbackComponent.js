import React, { Component } from 'react'
import FeedbackService from '../services/FeedBackService'
import {Typography} from '@material-ui/core';

class ViewFeedbackComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            feedback: {}
        }
    }

    componentDidMount(){
        FeedbackService.getFeedbackById(this.state.id).then( res => {
            this.setState({feedback: res.data});
           
        })
        
    }

    render() {
        return (
            <div className="views">
                    <Typography variant="h4">
                        View FeedBack Details
                    </Typography>
                        <div className="view">
                                <div> 
                                Rating: {this.state.feedback.rating}
                                </div>
                                <div>
                                Feedback Details: {this.state.feedback.feedback_details}
                                </div>
                        
                            
                        </div>
                    </div>
        )
    }
}

export default ViewFeedbackComponent
