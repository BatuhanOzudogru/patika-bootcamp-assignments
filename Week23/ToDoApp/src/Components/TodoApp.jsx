import { useState } from "react";

const TodoApp = () => {
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
  const [newTodo, setNewTodo] = useState("");
  const [filter, setFilter] = useState("all");

  const handleInputChange = (event) => {
    setNewTodo(event.target.value);
  };

  const handleClick = (index) => {
    const updatedTodos = [...todos];
    const editedTodo = { ...updatedTodos[index] };
    editedTodo.text = prompt("Edit todo", editedTodo.text);
    if (editedTodo.text !== null) {
      updatedTodos[index] = editedTodo;
      setTodos(updatedTodos);
    }
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
        <form
          onSubmit={(e) => {
            e.preventDefault();
            if (newTodo.trim()) {
              setTodos([...todos, { text: newTodo, done: false }]);
              setNewTodo("");
            }
          }}
        >
          <input
            className="new-todo"
            placeholder="What needs to be done?"
            autoFocus
            value={newTodo}
            onChange={handleInputChange}
          />
        </form>
      </header>

      <section className="main" hidden={todos.length === 0}>
        <ul className="todo-list">
          {filteredTodos.map((todo, index) => (
            <li key={index} className={todo.done ? "completed" : ""}>
              <div className="view">
                <input
                  className="toggle"
                  type="checkbox"
                  checked={todo.done}
                  onChange={() => {
                    const updatedTodos = [...todos];
                    updatedTodos[index].done = !updatedTodos[index].done;
                    setTodos(updatedTodos);
                  }}
                />
                <label onClick={() => handleClick(index)}>{todo.text}</label>
                <button
                  className="destroy"
                  onClick={() => {
                    const updatedTodos = [...todos];
                    updatedTodos.splice(index, 1);
                    setTodos(updatedTodos);
                  }}
                ></button>
              </div>
            </li>
          ))}
        </ul>
      </section>

      <footer className="footer" hidden={todos.length === 0}>
        <span className="todo-count">
          {countLeft} {countLeft === 1 ? "item" : "items"} left
        </span>

        <ul className="filters">
          <li>
            <a
              href="#/"
              className={filter === "all" ? "selected" : ""}
              onClick={(e) => {
                e.preventDefault();
                setFilter("all");
              }}
            >
              All
            </a>
          </li>
          <li>
            <a
              href="#/active"
              className={filter === "active" ? "selected" : ""}
              onClick={(e) => {
                e.preventDefault();
                setFilter("active");
              }}
            >
              Active
            </a>
          </li>
          <li>
            <a
              href="#/completed"
              className={filter === "completed" ? "selected" : ""}
              onClick={(e) => {
                e.preventDefault();
                setFilter("completed");
              }}
            >
              Completed
            </a>
          </li>
        </ul>

        <button
          className="clear-completed"
          hidden={todoDone === 0}
          onClick={() => setTodos(todos.filter((todo) => !todo.done))}
        >
          Clear completed
        </button>
      </footer>
    </section>
  );
};

export default TodoApp;
