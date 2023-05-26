import React, { useState } from 'react';
import axios from 'axios';

const GradeAssignment = () => {
  const [feedback, setFeedback] = useState('');
  const [grade, setGrade] = useState('');
  const [studentId, setStudentId] = useState('');
  const [assignmentId, setAssignmentId] = useState('');
 

  const handleFeedbackChange = (event) => {
    setFeedback(event.target.value);
  };

  const handleGradeChange = (event) => {
    setGrade(event.target.value);
  };

  const handleStudentIdChange = (event) => {
    setStudentId(event.target.value);
  };

  const handleAssignmentIdChange = (event) => {
    setAssignmentId(event.target.value);
  };



  const handleSubmit = (event) => {
    event.preventDefault();

    // Create an object with the grading data
    const gradingData = {
      feedBack: feedback,
      grade: grade,
      studentId: studentId,
      assignmentId: assignmentId
     
    };

    // Send the grading data to the server
    axios.post('http://localhost:9999/axis/submission', gradingData)
      .then((response) => {
        console.log('Grading successful:', response.data);
        // Perform any additional actions after grading, such as updating the UI
      })
      .catch((error) => {
        console.error('Error grading assignment:', error);
      });

    // Reset the form fields
    setFeedback('');
    setGrade('');
    setStudentId('');
    setAssignmentId('');
    
  };

  return (
    <div className="grade-assignment-container">
      <h2>Grade Assignment</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="feedback">Feedback:</label>
          <textarea id="feedback" className="form-control" value={feedback} onChange={handleFeedbackChange} />
        </div>
        <div className="form-group">
          <label htmlFor="grade">Grade:</label>
          <input type="text" id="grade" className="form-control" value={grade} onChange={handleGradeChange} />
        </div>
        <div className="form-group">
          <label htmlFor="studentId">Student ID:</label>
          <input type="text" id="studentId" className="form-control" value={studentId} onChange={handleStudentIdChange} />
        </div>
        <div className="form-group">
          <label htmlFor="assignmentId">Assignment ID:</label>
          <input type="text" id="assignmentId" className="form-control" value={assignmentId} onChange={handleAssignmentIdChange} />
        </div>
       
        <button type="submit" className="btn btn-primary">Grade Assignment</button>
      </form>
    </div>
  );
};

export default GradeAssignment;
