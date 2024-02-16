import React from "react";
import { useContext } from "react";
import { ReviewContext } from "../../contexts/ReviewContext";

const ReviewProvider = () => {
  const { users, setUsers } = useContext(ReviewContext);

  return (
    <section id="review" className="review-section center">
      <div className="review-intro">
        <h2>REVIEW CLIENT</h2>
        <p></p>
        <p className="explanation">
          Lorem Ipsum is not simply random text. It has roots in a piece of
          classical at Hampden-Sydney College.
        </p>
      </div>
      <div className="review-users-comments">
        {users.map((user) => (
          <div className="review-cards" key={user.id}>
            <div className="review-profile">
              <div className="review-figure">
                <img src={user.img} alt="" />
              </div>
              <div className="review-info">
                <h3>{user.job}</h3>
                <p>{user.title}</p>
              </div>
            </div>
            <div className="review-comment">
              <p>
              {user.comment}
              </p>
            </div>
            <div className="review-comment-clip-path-all">
              <div className="review-comment-clip-path-left"></div>
              <div className="review-comment-clip-path-right"></div>
            </div>
          </div>
        ))}
      </div>
    </section>
  );
};

export default ReviewProvider;
