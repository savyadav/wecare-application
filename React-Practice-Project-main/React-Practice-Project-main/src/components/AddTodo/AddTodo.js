import React from 'react'
import { connect } from 'react-redux';
import { addTodo } from '../../actions';
function AddTodo(props) {
    console.log(props);
  return (
    <form onSubmit={(event)=>{
        event.preventDefault();
        
        let input = event.target.userInput.value;
        props.dispatch(addTodo(input));
        console.log(input);
    }}>
        <input type="text" name="userInput"/> 
        <button>Submit</button>
    </form>
  )
}

export default connect()(AddTodo)