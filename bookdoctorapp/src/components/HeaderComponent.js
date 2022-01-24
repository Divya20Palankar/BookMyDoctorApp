import React from "react";
import {
  AppBar,
  Toolbar,
  CssBaseline,
  Typography,
  makeStyles,
} from "@material-ui/core";
import { Link } from "react-router-dom";
import Home from "@material-ui/icons/Home";
import InfoIcon from "@material-ui/icons/Info";
import ContactsIcon from "@material-ui/icons/Contacts";
import AccountBoxIcon from "@material-ui/icons/AccountBox";

const useStyles = makeStyles((theme) => ({
  navlinks: {
    marginLeft: theme.spacing(10),
    display: "flex",
  },
 logo: {
    flexGrow: "1",
    cursor: "pointer",
  },
  link: {
    textDecoration: "none",
    color: "white",
    fontSize: "20px",
    marginLeft: theme.spacing(10),
    "&:hover": {
      color: "yellow",
      borderBottom: "1px solid white",
    },
  },
}));

function Navbar() {
  const classes = useStyles();

  return (
    <AppBar position="static" style={{background: '#212121'}}>
      <CssBaseline />
      <Toolbar>
        <Typography variant="h4" className={classes.logo}>
          Book My Doctor
        </Typography>
          <div className={classes.navlinks}>
            <Link to="/" className={classes.link}>
              <Toolbar>
                <Home/>
                Home
              </Toolbar>
            </Link>
            <Link to="/about" className={classes.link}>
              <Toolbar>
                <InfoIcon/>
                  About
              </Toolbar>
            </Link>
            <Link to="/login" className={classes.link}>
              <Toolbar>
                <AccountBoxIcon/>
                  Login
              </Toolbar>
            </Link>
          </div>
      </Toolbar>
    </AppBar>
  );
}
export default Navbar;