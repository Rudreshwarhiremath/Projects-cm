import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './StudentEnrolled.css';

const EnrolledStudents = () => {
  const [users, setStudents] = useState([]);
  const [userName , setUserName] = useState();

  useEffect(() => {
    
    const data = localStorage.getItem('userName')
    console.log(data);
    setUserName(data);
    // Fetch the enrolled students for the teacher from the server
    axios.get(`http://localhost:9999/axis/enrolList?userName=${userName}`)
      .then((response) => {
        console.log('Enrolled students:', response.data);
        setStudents(response.data);
      })
      .catch((error) => {
        console.error('Error fetching enrolled students:', error);
      });
  }, []);

  return (
    <div className="enrolled-students-container">
      <h2>Enrolled Students</h2>
      {users.length >= 0 ? (
        <table className="enrolled-students-table">
          <thead>
            <tr>
              <th>User Name</th>
            </tr>
          </thead>
          <tbody>
            {users.map((student) => (
              <tr key={student.users}>
                <td>{student.users}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No students enrolled.</p>
      )}
    </div>
  );
};

export default EnrolledStudents;


