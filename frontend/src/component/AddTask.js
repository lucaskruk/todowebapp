import React from "react";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
import { Link } from "react-router-dom";
import Grid from "@material-ui/core/Grid";
import GroupIcon from "@material-ui/icons/Group";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";

const useStyles = makeStyles(theme => ({
  paper: {
    marginTop: theme.spacing(7),
    display: "flex",
    flexDirection: "column",
    alignItems: "center"
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(3)
  },
  submit: {
    margin: theme.spacing(3, 0, 2)
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: "100%"
  }
}));

export default function AddTask(){
    const classes = useStyles();
    const[firstLoad, setLoad] = React.useState(true);

    const [selectedDate, setSelectedDate] = React.useState(
        new Date()
    );

    const [taskname, setTaskname] = React.useState("Write Code");
    const [status, setStatus] = React.useState("Active");

    const handleDateChange = event => setSelectedDate(event.target.value);
    const handleTasknameChange = event => setTaskname(event.target.value);
    const handleStatusChange = event => setStatus(event.target.value);

    const [message, setMessage] = React.useState("Nothing saved in the session");

    async function sampleFunc(toInput){
    	const response = await fetch("/api/task",{
			method : "POST",
			cache : "no-cache",
			credentials : "include",
			headers : {
				"Content-Type":"application/json"
			},
			redirect : "follow",
			referrerPolicy: "no-referrer", // no-referrer, *client
	      	body: JSON.stringify(toInput)

    	});
    	let body = await response.json();
    	//console.log(body.id);
    	setMessage(body.id ? "Data successfully updated" : "Data updation failed");
    }

    const handleSubmit = variables => {
    	const toInput = {taskname,status, dueDate:selectedDate};
    	sampleFunc(toInput);
    	setTaskname("");
    	setStatus("");
    };

    if(firstLoad){
    	setLoad(false);
    }

    return(
    	<Container component="main" maxWidth="xs">
    	   <CssBaseline />
    	   <div className={classes.paper}>
    	   	<Avatar className={classes.paper}>
    	   	   <GroupIcon />
    	   	</Avatar>
    	   	<Typography component="h1" variant="h5">
    	   	  Tasks
    	   	</Typography>
    	   	<form className={classes.form} noValidate>
    	   	   <Grid container spacing={2}>
    	   	    <Grid item xs={12}>
    	   	      <TextField
    	   	         variant = "outlined"
    	   	         required
			 	     fullWidth
			         id="taskname"
			         value={taskname.text}
			         label="Taskname"
			         name="taskname"
			         autoComplete="taskname"
			         onChange={handleTasknameChange}
              		/>
		   </Grid>
		   <Grid item xs={12} sm={6}>
		                 <TextField
		                   autoComplete="status"
		                   name="status"
		                   variant="outlined"
		                   required
		                   fullWidth
		                   value={status.text}
		                   id="status"
		                   label="Status"
		                   onChange={handleStatusChange}
		                 />
                   </Grid>
                   <Grid item xs={12}>
		                 <TextField
		                   id="date"
		                   label="Due Date"
		                   type="date"
		                   defaultValue={""}
		                   className={classes.textField}
		                   InputLabelProps={{
		                     shrink: true
		                   }}
		                   onChange={handleDateChange}
		                 />
                  </Grid>
                 </Grid>
                 <Button
		             // type="submit"
		             fullWidth
		             variant="contained"
		             color="primary"
		             preventDefault
		             className={classes.submit}
		             onClick={handleSubmit}
		           >
		             Save
                 </Button>
                 <Grid container justify="center">
		            <Grid item>
		               <Link to="/view">View Tasks</Link>
		            </Grid>
		 </Grid>
              </form>
    	      <Typography style={{ margin: 7 }} variant="body1">
	              Status: {message}
	      </Typography>
	    </div>
       </Container>    );
}
