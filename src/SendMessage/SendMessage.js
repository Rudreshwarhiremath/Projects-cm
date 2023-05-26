import React, { useState } from 'react';
import axios from 'axios';

const SendingMessage = () => {
  const [senderId, setSenderId] = useState('');
  const [reciverId, setReciverId] = useState('');
  const [messageText, setMessageText] = useState('');
  
 

  const handleFeedbackChange = (event) => {
    setSenderId(event.target.value);
  };

  const handleGradeChange = (event) => {
    setReciverId(event.target.value);
  };

  const handleStudentIdChange = (event) => {
    setMessageText(event.target.value);
  };

 



  const handleSubmit = (event) => {
    event.preventDefault();

    // Create an object with the grading data
    const gradingData = {
        messageText: messageText,
        reciverId: reciverId,
        senderId: senderId,
      
     
    };

    // Send the grading data to the server
    axios.post('http://localhost:9999/axis/user/sendMessage', gradingData)
      .then((response) => {
        console.log('Message sent successful:', response.data);
         alert('Message sent!');
        // Perform any additional actions after grading, such as updating the UI
      })
      .catch((error) => {
        console.error('failed to send message:', error);
      });

    // Reset the form fields
    setMessageText('');
    setReciverId('');
    setSenderId('');
    
    
  };

  return (
    <div className="grade-assignment-container">
      <h2> Send notification</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="text">notification:</label>
          <textarea id="messageText" className="form-control" value={messageText} onChange={handleStudentIdChange} />
        </div>
        <div className="form-group">
          <label htmlFor="text">Sender name:</label>
          <input type="text" id="senderId" className="form-control" value={senderId} onChange={handleFeedbackChange} />
        </div>
        <div className="form-group">
          <label htmlFor="text">Reciver Name:</label>
          <input type="text" id="reciverId" className="form-control" value={reciverId} onChange={handleGradeChange} />
        </div>
      
       
        <button type="submit" className="btn btn-primary">Grade Assignment</button>
      </form>
    </div>
  );
};

export default SendingMessage;
