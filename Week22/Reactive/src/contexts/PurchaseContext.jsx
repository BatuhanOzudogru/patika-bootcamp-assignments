import React, { createContext, useState } from "react";

const PurchaseContext = createContext();

const PurchaseProvider = ({ children }) => {
  const [products, setProducts] = useState([
    {
      id: 1,
      img: "src/assets/purchase1.jpg",
      name: "Kettlebell / 5kg",
      price: "89,99",
      discountPrice: "59,99$",
    },
    {
      id: 2,
      img: "src/assets/purchase2.jpg",
      name: "Treadmill",
      price: "899,99",
      discountPrice: "599,99$",
    },
    {
      id: 3,
      img: "src/assets/purchase3.jpg",
      name: "Adjustable Dumbbell",
      price: "89,99",
      discountPrice: "59,99$",
    },
    {
      id: 4,
      img: "src/assets/purchase4.jpg",
      name: "Kettlebell / 3kg",
      price: "89,99",
      discountPrice: "59,99$",
    },
  ]);

  return (
    <PurchaseContext.Provider value={{ products, setProducts }}>
      {children}
    </PurchaseContext.Provider>
  );
};

export { PurchaseContext, PurchaseProvider };
