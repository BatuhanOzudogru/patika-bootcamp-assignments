import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import * as React from "react";
import { getStarship } from "../API/Starship";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { IconButton } from "@mui/material";
import { CardActionArea } from "@mui/material";
import ArrowBackRoundedIcon from "@mui/icons-material/ArrowBackRounded";
import "./Details.css";

function Details() {
  const { id } = useParams();
  const [starship, setStarship] = useState({});
  const [reload, setReload] = useState(true);

  useEffect(() => {
    getStarship(id).then((data) => {
      setStarship(data);
      setReload(false);
    });
  }, [reload, id]);

  if (reload || !starship) {
    return <h1>Loading...</h1>;
  }

  return (
    <div className="container">
      <div className="back-button">
        <a href="/">
          <IconButton>
            <ArrowBackRoundedIcon />
          </IconButton>
        </a>
      </div>
      <div className="card-container">
        <Card sx={{ maxWidth: 345, borderRadius: 7, backgroundColor : "#111423", color : "#c0c2d9"}}>
          <CardActionArea>
            <Typography gutterBottom variant="h5" component="div" sx={{textAlign: "center"}}>
              {starship.name}
              <hr />
            </Typography>
            <CardMedia
              component="img"
              height="140"
              image="https://content.invisioncic.com/x311865/monthly_2022_06/HWC_Article_Header_HHR14_SWStarships_v1a.jpg.fbaf20672ce772a26f304014c5b99c9e.jpg"
              alt={starship.name}
              sx={{ borderRadius: 7 }}
            />
            <CardContent sx={{ textAlign: "center" }}>
              <Typography variant="body2" color="text.secondary" sx={{color : "#c0c2d9"}}>
                <strong>Model:</strong> {starship.model}
                <br />
                <strong>Hyperdrive Rating :</strong> {starship.hyperdrive_rating}
                <br />
                <strong>Passengers :</strong> {starship.passengers}
                <br />
                <strong>Max Atmosphering Speed :</strong> {starship.max_atmosphering_speed}
                <br />
                <strong>Manufacturer :</strong> {starship.manufacturer}
                <br />
                <strong>Crew : </strong> {starship.crew}
                <br />
                <strong>Cargo Capacity </strong>{starship.cargo_capacity}
                <br />
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </div>
    </div>
  );
}

export default Details;
