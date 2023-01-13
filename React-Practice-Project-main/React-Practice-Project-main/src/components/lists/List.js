import React from 'react'
import { connect } from 'react-redux'
import { deleteTodo } from '../../actions';
function List(props) {
    console.log(props);
  return (
    <div>
        <ul>
            {props.lists.map(
                (list,index)=>
                    <li key={index}>{list.text}
                    <button onClick={()=>props.dispatch(deleteTodo(list.id))}>
                        Delete</button></li>
                
            )}
        </ul>
    </div>
  )
}

const mapData = (state)=>({
 lists:state.todos.data
})
export default  connect(mapData)(List)