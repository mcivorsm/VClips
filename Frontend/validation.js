function validateEmail(input) {

    var validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
  
    if (input.value.match(validRegex)) {
  
      alert("Valid email address!");
  
      document.form1.text1.focus();
  
      return true;
  
    } else {
  
      alert("Invalid email address!");
  
      document.form1.text1.focus();
  
      return false;
  
    }

    
  
  }
  function validateForm() {
    // Get the username and password values
    const email = document.getElementById('email').value;
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const message = document.getElementById('message');
    
    // Clear any previous messages
    message.textContent = '';
if(validateEmail(email) === false){
  message.textContent = 'Invalid Email address';
  return false;
}
    // Basic check to see if fields are not empty
    if (username === '' || password === '') {
        message.textContent = 'Please fill out all fields.';
        return false;
    } else {
        // Here you would normally send data to the server for verification
        // But we'll just simulate a login attempt
        if (username === 'admin' && password === 'password') {
            message.textContent = 'Login successful!';
            message.style.color = 'green';
        } else {
            message.textContent = 'Invalid username or password.';
        }
        return false; // Prevents form from refreshing the page
    }
}