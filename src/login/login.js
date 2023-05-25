import React, { useState } from 'react';
import './LoginPage.css';
import { Link, useNavigate } from 'react-router-dom';
import { Button } from 'react-bootstrap';



const LoginPage = () => {
    const navigate=useNavigate()
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const [roles, setRole] = useState('');

    const handleUserNameChange = (event) => {
        setUserName(event.target.value);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };
    const handleRoleChange = (event) => {
        setRole(event.target.value);
      };

    const handleSubmit = (event) => {
        event.preventDefault();

        // Prepare the URL with parameters
        const url = `http://localhost:9999/axis/user/login?userName=${encodeURIComponent(userName)}&password=${encodeURIComponent(password)}`;

        // Send the data to the server
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
        })
            .then(response => response.json())
            .then(result => {
                // Handle the response from the server
                console.log('Login successful:', result.role);
                setUserName(result.userName);
                
                setRole(result.roles);
               
                // Reset the form
            
                setPassword('');

            })
            .catch(error => {
                // Handle any errors
                console.error('Error logging in:', error);
            });

    };
    const handleClick=(event , props)=>{
        if(roles==="STUDENT"){
            console.log(props);
            
            localStorage.setItem('userName', props);
            console.log("Saved To local storage");
            navigate("/StudentNavbar")
            

        } if(roles==="TEACHER") {
            navigate("/TeacherDashbord");
        }
    }
    console.log(userName)
    return (
        
        
        <div className="login-container">
            <h2>Login Page</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="userName">Username:</label>
                    <input
                        type="text"
                        id="userName"
                        value={userName}
                        onChange={handleUserNameChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password:</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={handlePasswordChange}
                        required
                    />
                </div>
                <div>
          <label htmlFor="role">Role:</label>
          <select
            id="role"
            name="role"
            value={roles}
            onChange={handleRoleChange}
            required
          >
            <option value="">Select Role</option>
            <option value="ADMIN">ADMIN</option>
            <option value="TEACHER">TEACHER</option>
            <option value="STUDENT">STUDENT</option>
          </select>
        </div>
              
                <Button type='submit' onClick={(event)=>handleClick(event , userName)}>Login</Button>
            
            </form>
        </div>
    );
};

export default LoginPage;
