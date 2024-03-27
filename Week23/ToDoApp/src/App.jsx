import "./App.css";
import { useState } from "react";
import TodoFooter from "./Components/TodoFooter";
import TodoForm from "./Components/TodoForm";
import TodoList from "./Components/TodoList";

function App() {
  const initialData = {
    todo: [
      { done: true, text: "Taste JavaScript" },
      { text: "Code furiously", done: true },
      { text: "Promote Mavo", done: false },
      { text: "Give talks", done: false },
      { text: "Write tutorials", done: true },
      { text: "Have a life!", done: false },
    ],
  };

  const [todos, setTodos] = useState(initialData.todo);
  const [filter, setFilter] = useState("all");

  const handleToggle = (index) => {
    const newIndex = todos.findIndex((todo) => todo === filteredTodos[index]);

    const updatedTodos = todos.map((todo, todoIndex) => {
      if (todoIndex === newIndex) {
        return {
          ...todo,
          done: !todo.done,
        };
      }
      return todo;
    });
    setTodos(updatedTodos);
  };

  const handleClick = (index) => {
    const newIndex = todos.findIndex((todo) => todo === filteredTodos[index]);
    const updatedTodos = [...todos];
    const editedTodo = { ...updatedTodos[newIndex] };
    editedTodo.text = prompt("Edit todo", editedTodo.text);
    if (editedTodo.text !== null) {
      updatedTodos[index] = editedTodo;
      setTodos(updatedTodos);
    }
  };

  const addTodo = (text) => {
    setTodos([...todos, { text, done: false }]);
  };

  const clearCompleted = () => {
    setTodos(todos.filter((todo) => !todo.done));
  };

  const countLeft = todos.filter((todo) => !todo.done).length;
  const todoDone = todos.filter((todo) => todo.done).length;

  const filteredTodos = todos.filter((todo) => {
    if (filter === "all") return true;
    if (filter === "active") return !todo.done;
    if (filter === "completed") return todo.done;
  });

  return (
    <section className="todoapp">
      <header className="header">
        <h1>todos</h1>
        <TodoForm addTodo={addTodo} todos={todos} setTodos={setTodos} />
      </header>

      <section className="main" hidden={todos.length === 0}>
        <TodoList
          todos={todos}
          filter={filter}
          handleToggle={handleToggle}
          handleClick={handleClick}
          setTodos={setTodos}
        />
      </section>

      <TodoFooter
        countLeft={countLeft}
        todoDone={todoDone}
        setFilter={setFilter}
        clearCompleted={clearCompleted}
      />
    </section>
  );
}

export default App;
