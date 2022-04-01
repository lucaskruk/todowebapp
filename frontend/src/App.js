import React, {Component} from 'react';
import AddTask from "./component/AddTask";
import {
  BrowserRouter as Router,
  Route,
  Routes,
} from "react-router-dom";
import Table from "./component/Table"

class App extends Component{
	render(){
		return(
		        <Router>
		            <Routes>
                        <Route path='/' element={<AddTask/>} />
                        <Route path='/view' element={<Table/>} />
		            </Routes>
		        </Router>
			)
	}
}

export default App;