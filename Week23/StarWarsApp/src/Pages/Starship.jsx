import { useState, useEffect } from "react";
import * as React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { getStarships } from "../API/Starship";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActionArea } from "@mui/material";
import Button from "@mui/material/Button";
import SendIcon from "@mui/icons-material/Send";

function Starship() {
  const [starships, setStarships] = useState([]);
  const [reload, setReload] = useState(true);
  const [searchTerm, setSearchTerm] = useState("");
  const [loadedStarships, setLoadedStarships] = useState(5);

  useEffect(() => {
    getStarships().then((data) => {
      setStarships(data.results);
      setReload(false);
    });
  }, [reload]);

  const handleSearch = () => {
    const results = starships.filter((item) =>
      item.name.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setStarships(results);
    setReload(false);
  };

  const loadMoreStarships = () => {
    setLoadedStarships((prevCount) => prevCount + 5);
  };

  if (reload || starships.length === 0) {
    return <h1>Loading...</h1>;
  }

  return (
    <>
      <div>
        <h1>Starships</h1>

        <div className="search">
          <input
            type="text"
            name="search"
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
          <Button
            variant="contained"
            endIcon={<SendIcon />}
            onClick={handleSearch}
          >
            Filter
          </Button>
        </div>

        {starships.slice(0, loadedStarships).map((starship) => (
          <a
            href={`/starships/${starship.url.split("/")[5]}`}
            key={starship.url.split("/")[5]}
          >
            <Card sx={{ maxWidth: 345 }}>
              <CardActionArea>
                <CardMedia
                  component="img"
                  height="140"
                  image="https://content.invisioncic.com/x311865/monthly_2022_06/HWC_Article_Header_HHR14_SWStarships_v1a.jpg.fbaf20672ce772a26f304014c5b99c9e.jpg"
                  alt={starship.name}
                />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="div">
                    {starship.name}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Model : {starship.model}
                    <br />
                    Hyperdrive Rating : {starship.hyperdrive_rating}
                  </Typography>
                </CardContent>
              </CardActionArea>
            </Card>
          </a>
        ))}
        {starships.length > loadedStarships && (
          <Button variant="contained" onClick={loadMoreStarships}>
            Load More
          </Button>
        )}
      </div>
    </>
  );
}

export default Starship;
