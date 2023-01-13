import logo from './logo.svg';
import './App.css';
import AddTodo from './components/AddTodo/AddTodo';
import List from './components/lists/List';

function App() {
  return (
    <div className="App">
     <AddTodo/>
     <List/>
    </div>
  );
}
export default App;
