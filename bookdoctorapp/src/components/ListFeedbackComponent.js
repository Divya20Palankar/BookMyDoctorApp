import React, { Component } from 'react'
import FeedbackService from '../services/FeedBackService'
import { Route , history} from 'react-router-dom';
import {Table,TableBody,TableCell,TableContainer,TableHead,TableRow,Paper,Button,Typography,} from '@material-ui/core'

class ListFeedbackComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                feedbacks: []
        }
        this.addFeedback = this.addFeedback.bind(this);
        this.editFeedback = this.editFeedback.bind(this);
        this.deleteFeedback = this.deleteFeedback.bind(this);
    }

    deleteFeedback(id){
        FeedbackService.deleteFeedback(id).then( res => {
            this.setState({feedbacks: this.state.feedbacks.filter(feedback => feedback.id !== id) });
            
        });
    } 
    viewFeedback(id){
        this.props.history.push(`/view-feedback/${id}`);
    }
    editFeedback(id){
        this.props.history.push(`/add-feedBack/${id}`);
    }

    componentDidMount(){
        FeedbackService.getFeedbacks().then((res) => {
            this.setState({ feedbacks: res.data});
        });
    }
    addFeedback(){
        this.props.history.push('/add-feedback/_add');
    }
    render() {
        return (
            <div className="bg">
                 <div className="table">
                 <Typography variant="h4" className="allign">
                 FeedBacks List
                </Typography>
                <div className="button">
                  <Button className="button" color="primary" variant="contained"size="small" onClick={this.addFeedback}>Add Feedback</Button>
                  </div>
                  <div className="feed">
                 <TableContainer component={Paper}>
                        <Table className="material-table"aria-label="simple table" >
                             <TableHead className="tableHead">
                                <TableRow>
                                    
                                    <TableCell align="center">Rating</TableCell>
                                    <TableCell align="center">Feedback</TableCell>
                                   
                                    <TableCell align="center">Action</TableCell> 
                                </TableRow>
                            </TableHead>
                             <tbody>
                                {
                                    this.state.feedbacks.map(
                                        feedback => 
                                       <TableRow key = {feedback.feedbackId}>
                                                    
                                                   
                                                    <TableCell align="center">{feedback.rating}</TableCell>
                                                    <TableCell align="center">{feedback.feedback_details}</TableCell>
                                                    <TableCell align="center">
                                                        
                                                         <Button variant="contained"size="small" color="primary" onClick={ () => this.editFeedback(feedback.feedbackId)}>Update</Button>
                                                        <Button variant="contained"size="small" color="secondary" onClick={ () => this.deleteFeedback(feedback.feedbackId)}>Delete</Button> 
      </TableCell>

                                                </TableRow>
                                    ) }
                            </tbody> 
                         
                 </Table>
                </TableContainer>
                </div>
                </div>
                </div>
        )
    }
}

export default ListFeedbackComponent
