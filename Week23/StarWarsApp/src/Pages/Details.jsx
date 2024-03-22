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
    <>
      <div>
        <a href={`/`}>
          <IconButton>
            <ArrowBackRoundedIcon />
          </IconButton>
        </a>

        <Card sx={{ maxWidth: 345 }}>
          <CardActionArea>
            <Typography gutterBottom variant="h5" component="div">
              {starship.name}
              <hr />
            </Typography>
            <CardMedia
              component="img"
              height="140"
              image="https://content.invisioncic.com/x311865/monthly_2022_06/HWC_Article_Header_HHR14_SWStarships_v1a.jpg.fbaf20672ce772a26f304014c5b99c9e.jpg"
              alt={starship.name}
            />
            <CardContent>
              <Typography variant="body2" color="text.secondary">
                Model : {starship.model}
                <br />
                Hyperdrive Rating : {starship.hyperdrive_rating}
                <br />
                Passengers : {starship.passengers}
                <br />
                Max Atmosphering Speed : {starship.max_atmosphering_speed}
                <br />
                Manufacturer : {starship.manufacturer}
                <br />
                Crew : {starship.crew}
                <br />
                Cargo Capacity {starship.cargo_capacity}
                <br />
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </div>
    </>
  );
}

export default Details;
