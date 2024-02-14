import ClassButton from "./ClassButton"
import { useContext, useState } from "react";
import { DataContext } from "../../contexts/DataContext";

const Class = () => {
  const { btnFeatures, setBtnFeatures, content, setContent } =
    useContext(DataContext);

  return (
    <section id="classes" className="classes-section center">
    <div className="classes-intro">
      <h2>OUR CLASSES</h2>
      <p></p>
      <p className="explanation">
        Lorem Ipsum is not simply random text. It has roots in a piece of classical at Hampden-Sydney College.
      </p>
    </div>
    <ClassButton/>
  </section>
  )
}

export default Class