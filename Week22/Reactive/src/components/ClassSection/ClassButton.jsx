import React, { useContext, useState } from "react";
import { DataContext } from "../../contexts/DataContext";

const ClassButton = () => {
  const { btnFeatures, setBtnFeatures, content } = useContext(DataContext);

  // Maintain a state to track the selected button index
  const [selectedButtonIndex, setSelectedButtonIndex] = useState(0);

  const handleClick = (btn, index) => {
    const updatedButtons = btnFeatures.map((button, i) => ({
      ...button,
      className: i === index ? "features-btn-active" : "",
    }));

    // Update the state with the selected button index
    setSelectedButtonIndex(index);

    setBtnFeatures(updatedButtons);
  };

  // Use the selectedButtonIndex to get the corresponding content
  const selectedContent = content[selectedButtonIndex];

  return (
    <>
      <div className="features" id="features">
        {btnFeatures.map((btn, index) => (
          <button
            key={btn.id}
            onClick={() => handleClick(btn, index)}
            className={btn.className}
          >
            {btn.name}
          </button>
        ))}
      </div>
      <div className="classes-content">
        {/* Use the selectedContent directly, no need for filtering */}
        <div className="classes-content-article">
          <div>
            <h2>Why are your {selectedContent.category}?</h2>
            <br />
            <p>{selectedContent.text}</p>
            <br />
          </div>
          <div>
            <h2>It's Your {selectedContent.category} Time.</h2>
            <br />
            <p>Saturday-Sunday: 8:00am - 10:00am</p>
            <br />
            <p>Monday-Tuesday: 10:00am - 12:00pm</p>
            <br />
            <p>Wednesday-Friday: 3:00pm - 6:00pm</p>
          </div>
        </div>
        <div className="classes-content-figure">
          <img src={selectedContent.img} alt="" />
        </div>
      </div>
    </>
  );
};

export default ClassButton;
