import React, { createContext, useState } from "react";

const ReviewContext = createContext();

const ReviewProvider = ({ children }) => {
  const [users, setUsers] = useState([
    {
      id: 1,
      img: "src/assets/client1.jpg",
      job: "Diet Expert",
      title: "CFO",
      comment:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium, quaerat doloribus enim dolore ad fuga dolores culpa maiores optio pariatur delectus voluptate, beatae sed dignissimos rem.",
    },
    {
      id: 2,
      img: "src/assets/client2.jpg",
      job: "Cardio Trainer",
      title: "CEO",
      comment:
        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Totam quasi atque cumque harum quaerat, amet dolorum velit in sequi. Doloribus voluptatem, animi laudantium provident nam minus.",
    },
  ]);

  return (
    <ReviewContext.Provider value={{ users, setUsers }}>
      {children}
    </ReviewContext.Provider>
  );
};

export { ReviewContext, ReviewProvider };
