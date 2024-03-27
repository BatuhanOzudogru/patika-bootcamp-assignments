// TodoFooter.jsx
import React from "react";

const TodoFooter = ({ countLeft, todoDone, setFilter, clearCompleted }) => {
  return (
    <footer className="footer" hidden={countLeft + todoDone === 0}>
      <span className="todo-count">
        {countLeft} {countLeft === 1 ? "item" : "items"} left
      </span>

      <ul className="filters">
        <li>
          <a
            href="#/"
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
        onClick={clearCompleted}
      >
        Clear completed
      </button>
    </footer>
  );
};

export default TodoFooter;
