import {Link} from 'react-router-dom';

export default function login(){
  return(
    <div className="login">
<div>
  <Link to="/admin">Admin</Link>
 </div>
  <div>
 <Link to="/doctorLogin">Doctor</Link>
</div>
<div>
  <Link to="/patient">Patient</Link>
</div> 
</div>
  )}

