import { useContext } from "react";
import { ItemContext } from "../ItemContext";

const Card = () => {
  const { items, setItems } = useContext(ItemContext);

  const handleBuy = (item) => {
    const updatedItems = [...items];
    const index = updatedItems.findIndex((element) => element.id === item.id);

    if (index !== -1) {
      updatedItems[index] = {
        ...updatedItems[index],
        amount: updatedItems[index].amount + 1,
      };
      setItems(updatedItems);
    }
  };

  const handleSell = (item) => {
    const updatedItems = [...items];
    const index = updatedItems.findIndex((element) => element.id === item.id);

    if (index !== -1) {
      updatedItems[index] = {
        ...updatedItems[index],
        amount: updatedItems[index].amount - 1,
      };
      setItems(updatedItems);
    }
  };

  return (
    <div className="items">
      {items.map((item) => (
        <div key={item.id} className="item-wrapper">
          <img className="item-img" src={item.img} alt="item-img" />
          <div className="item-name">{item.name}</div>
          <div className="item-cost">${item.price.toLocaleString("en-US")}</div>
          <div className="item-controls">
            <button
              onClick={() => handleSell(item)}
              disabled={item.amount === 0}
              className="item-sell"
            >
              Sell
            </button>
            <input
              pattern="\d*"
              type="number"
              className="item-input"
              value={item.amount}
              readOnly
            />
            <button onClick={() => handleBuy(item)} className="item-buy">
              Buy
            </button>
          </div>
        </div>
      ))}
    </div>
  );
};

export default Card;
