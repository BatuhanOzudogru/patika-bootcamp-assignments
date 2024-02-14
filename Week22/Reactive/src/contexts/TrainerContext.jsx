import React, { createContext, useState } from "react";

const TrainerContext = createContext();

const TrainerProvider = ({ children }) => {
  
  const [trainers, setTrainers] = useState([
    {
      id: 1,
      img : "src/assets/trainer1.jpg",
      name: "Zoe Doe",
      department : "Yoga Trainer"
    },
    {
      id: 2,
      img : "src/assets/trainer2.jpg",
      name: "John Doe",
      department : "Fitness Trainer"
    },
    {
      id: 3,
      img : "src/assets/trainer3.jpg",
      name: "Jane Doe",
      department : "Cardio Trainer"
    },
  ])

  return (
    <TrainerContext.Provider
      value={{trainers, setTrainers}}
    >
      {children}
    </TrainerContext.Provider>
  );
};

export { TrainerContext, TrainerProvider };
