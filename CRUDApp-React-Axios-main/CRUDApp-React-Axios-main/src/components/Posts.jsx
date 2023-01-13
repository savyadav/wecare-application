import React,{useState,useEffect} from 'react'
import Axios from 'axios';
 const Posts = () => {
const baseUrl = "https://jsonplaceholder.typicode.com/posts";
const [postArr,setPostArr] = useState([]);
useEffect(()=>{
    Axios.get(baseUrl).then((response)=>{
        setPostArr(response.data);
    });
},[]);
if(postArr.length==0) return "<h1>There is No Data</h1>";
return (
    <div>
        <h1>All Post ({postArr.length})</h1>
        
        <ul>
        {postArr.map((post)=><li>{post.title}<button>Delete</button></li>)}
        </ul>
      </div>
  )
}

export default Posts;
