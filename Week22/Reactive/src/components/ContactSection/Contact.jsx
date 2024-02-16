import React from 'react';

const Contact = () => {
  return (
    <section id="contact" className="contact-us-section center">
      <div className="contact-us-intro">
        <h2>CONTACT US</h2>
        <p></p>
        <p className="explanation">
          Lorem Ipsum is not simply random text. It has roots in a piece of classical at Hampden-Sydney College.
        </p>
      </div>
      <div className="contact-us-content">
        <div className="contact-us-form">
          <div className="contact-us-form-head-section">
            <div className="head-left">
              <h3>Mobile Number</h3>
              <p>+135 773 321 4442</p>
            </div>
            <div className="head-right">
              <h3>Email Address</h3>
              <p>demo@demo.com</p>
            </div>
          </div>
          <div className="contact-us-form-sub-section">
            <ul>
              <li>
                <p>Make An Appointment</p>
              </li>
              <li><input type="text" placeholder="Your Name" /></li>
              <li><input type="email" placeholder="Your Email" /></li>
              <li><textarea name="" id="" cols="30" rows="5" placeholder="Your Message"></textarea></li>
              <li><button>Submit</button></li>
            </ul>
          </div>
        </div>
        <div className="contact-us-map">
          <iframe
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2990.2742577481954!2d-70.56107012345447!3d41.45496659179992!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89e52963ac45bbcb%3A0xf05e8d125e82af10!2sDos%20Mas!5e0!3m2!1str!2str!4v1706792927748!5m2!1str!2str"
            width="600" height="580"
            style={{ border: 0 }}
            allowFullScreen=""
            loading="lazy"
            referrerPolicy="no-referrer-when-downgrade"
          ></iframe>
        </div>
      </div>
    </section>
  );
}

export default Contact;
