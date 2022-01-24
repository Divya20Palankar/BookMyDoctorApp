import react from "react";
import "../App.css";
import {Typography} from "@material-ui/core";

function about(){
    return(
        <div className ="about">
            <Typography variant="h2">
                About Us
            </Typography>
            <Typography variant="h6" className="About-Us">
                Your Specialist will video call you for a consultation. You discuss all your symptoms and conditions with the specialist over the video call. This helps in better diagnosis and consultation.
            </Typography>
        </div>
    )
}

export default about;