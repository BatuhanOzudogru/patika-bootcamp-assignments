import React, { createContext, useState } from "react";

const DataContext = createContext();

const DataProvider = ({ children }) => {
  
  const [btnFeatures, setBtnFeatures] = useState([
    {
      id: 1,
      name: "Yoga",
      className : "features-btn-active",
    },
    {
      id: 2,
      name: "Group",
    },
    {
      id: 3,
      name: "Solo",
    },
    {
      id: 4,
      name: "Stretching",
    },
  ])


   const [content, setContent] = useState([
    {
      id: 1,
      img: "src/assets/yoga.jpg",
      category: "Yoga",
      text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis beatae veritatis, asperiores eveniet est nesciunt sequi ipsum dolorum?",
    },
    {
      id: 2,
      img: "src/assets/group.webp",
      category: "Group",
      text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde accusantium perferendis voluptatum delectus culpa at reiciendis facere quidem.",
    },
    {
      id: 3,
      img: "src/assets/solo.jpg",
      category: "Solo",
      text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Possimus corporis sit deserunt est totam culpa repellat cumque expedita.",
    },
    {
      id: 4,
      img: "src/assets/stret.webp",
      category: "Stretching",
      text: "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Impedit temporibus soluta ratione sapiente sequi illo est doloribus molestiae?",
    },
  ]);

  return (
    <DataContext.Provider
      value={{btnFeatures, setBtnFeatures, content, setContent }}
    >
      {children}
    </DataContext.Provider>
  );
};

export { DataContext, DataProvider };
