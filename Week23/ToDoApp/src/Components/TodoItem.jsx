const TodoItem = ({
  todo,
  index,
  handleToggle,
  handleClick,
  setTodos,
  todos,
}) => {
  return (
    <li className={todo.done ? "completed" : ""}>
      <div className="view">
        <input
          className="toggle"
          type="checkbox"
          checked={todo.done}
          onChange={() => handleToggle(index)}
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
  );
};

export default TodoItem;
