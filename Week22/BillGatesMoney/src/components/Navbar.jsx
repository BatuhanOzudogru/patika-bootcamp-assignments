import React, { useContext } from "react";
import { ItemContext } from "../ItemContext";

const Navbar = () => {
  const { items } = useContext(ItemContext);

  const totalValue = items.reduce(
    (acc, item) => acc + item.amount * item.price,
    0
  );

  const initialMoney = 100000000000;

  const remainingMoney = initialMoney - totalValue;

  return (
    <div className="money-bar">${remainingMoney.toLocaleString("en-US")}</div>
  );
};

export default Navbar;
