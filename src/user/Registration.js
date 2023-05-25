// import React, { useState, useEffect } from 'react';
// import {Form,Button} from 'react-bootstrap';
// import axios from 'axios';


// const Register = ()  => {
//   const [userData, setUserData] = useState({
 
//     userName: "",
//     password: ""
    
//     });
// const {userName,password}=userData;

//   useEffect(() => {
   
//   }, []);

//   const onInputChange = (e) => {

//     setUserData({ ...userData, [e.target.name]: e.target.value });
// };

// const onSubmit = async (e) => {
//     e.preventDefault();

   



//    const result= await axios.post( `http://localhost:9999/axis/user/register`, userData, {
//         headers: {
//             'Content-Type': 'application/json'
//         }

//     })
//     setUserData(result.data);
//     console.log(result);
// };
//   return (
//     <div style={{
//         display: 'block',
//         width: 700,
//         padding: 30
//     }}>
//         <h2>Register user</h2>
        
//         <Form onSubmit={(e) => onSubmit(e)}>
      
//             <Form.Group>
//                 <Form.Label>  Name </Form.Label>
//                 <Form.Control type="text"
//                     className="form__control"
//                     name="userName"
//                     placeholder="Enter your username"
//                     value={userName}
//                     onChange={(e) => onInputChange(e)}
//                 />
//         </Form.Group>
//                     <Form.Group>
//                         <Form.Label >Password </Form.Label>
//                         <Form.Control className="form__control"
//                             name="password"
//                             type={"password"}
//                             placeholder="Password"
//                             value={password}
//                             onChange={(e) => onInputChange(e)} />
//                     </Form.Group>
//                     <Button type="submit"  onChange={onSubmit}>Register</Button>
//                     &nbsp;&nbsp;&nbsp;
//                 </Form>
//        </div>
//   );
// };

// export default Register;

// import React, { useState } from 'react';

// const Dropdown = () => {
//   const [selectedOption, setSelectedOption] = useState('');

//   const handleOptionChange = (event) => {
//     setSelectedOption(event.target.value);
//   };

//   return (
//     <div>
//       <label htmlFor="dropdown">Select an option:</label>
//       <select id="dropdown" value={selectedOption} onChange={handleOptionChange}>
//         <option value="">Select an option</option>
//         <option value="option1">Option 1</option>
//         <option value="option2">Option 2</option>
//         <option value="option3">Option 3</option>
//       </select>
//       <p>Selected Option: {selectedOption}</p>
//     </div>
//   );
// };

// export default Dropdown;

import React, { useState } from 'react';

const RegisterPage = () => {
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');
  const [role, setRole] = useState('');

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

    // Prepare the data payload
    const data = {
      userName,
      password,
      role,
    };

    // Send the data to the server
    fetch('http://localhost:9999/axis/user/register', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      },
      body: JSON.stringify(data),
       
    })
      .then(response => response.text)
      .then(result => {
        // Handle the response from the server
        console.log('Registration successful:', result);
        // Reset the form
        setUserName('');
        setPassword('');
        setRole('');
      })
      .catch(error => {
        console.log('Registration successful:', data);
        // Handle any errors
        console.error('Error registering:', error);
      });
  };

  return (
    <div>
      <h2>Register Page</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="userName">Username:</label>
          <input
            type="text"
            id="userName"
            name="userName"
            value={userName}
            onChange={handleUserNameChange}
            required
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            name="password"
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
            value={role}
            onChange={handleRoleChange}
            required
          >
            <option value="">Select Role</option>
            <option value="ADMIN">ADMIN</option>
            <option value="TEACHER">TEACHER</option>
            <option value="STUDENT">STUDENT</option>
          </select>
        </div>
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default RegisterPage;


