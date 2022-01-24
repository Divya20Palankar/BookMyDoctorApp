import React from "react";
import {
  AppBar,
  Toolbar,
  CssBaseline,
  Typography,
  makeStyles,
  Container,
} from "@material-ui/core";

export default function Footer() {
    return (
        <AppBar position="static" style={{background: '#212121'}}>
          <Container maxWidth="md">
            <Toolbar>
              <Typography variant="h5" color="inherit">
              All Rights Reserved 2022 @
              </Typography>
            </Toolbar>
          </Container>
        </AppBar>
    )
}