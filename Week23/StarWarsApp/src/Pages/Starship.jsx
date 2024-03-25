import { useState, useEffect } from "react";
import * as React from "react";
import { getStarships } from "../API/Starship";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActionArea } from "@mui/material";
import Button from "@mui/material/Button";
import SendIcon from "@mui/icons-material/Send";
import "./Starship.css";

function Starship() {
  const [starships, setStarships] = useState([]);
  const [orginalStarships, setOrginalStarships] = useState([]);
  const [reload, setReload] = useState(true);
  const [searchTerm, setSearchTerm] = useState("");
  const [loadedStarships, setLoadedStarships] = useState(5);
  const [cardsMarginTop, setCardsMarginTop] = useState("10em"); // State for controlling margin-top of .cards

  useEffect(() => {
    getStarships().then((data) => {
      setStarships(data.results);
      setOrginalStarships(data.results);
      setReload(false);
    });
  }, [reload]);

  const handleSearch = () => {
    if (searchTerm.trim() == "") {
      setStarships(orginalStarships);
    } else {
      const results = orginalStarships.filter((item) =>
        item.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
        item.model.toLowerCase().includes(searchTerm.toLowerCase())
      );
      setStarships(results);
      setReload(false);
    }
  };

  const loadMoreStarships = () => {
    setLoadedStarships((prevCount) => prevCount + 5);
    setCardsMarginTop("3em"); // Update margin-top when loading more starships
  };

  if (reload) {
    return <h1>Loading...</h1>;
  }
  

  return (
    <>
      <div>
        <header>
          <img src="https://www.cdnlogo.com/logos/s/43/star-wars.svg" alt="" />
        </header>

        <div className="search">
          <label htmlFor="">Name / Model</label>
          <input
            type="text"
            name="search"
            placeholder="Name / Model"
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
          <br />
          <hr className="search-divider" />
        </div>
  
        {starships.length>0 && <div className="cards" style={{ marginTop: cardsMarginTop }}>
          {starships.slice(0, loadedStarships).map((starship) => (
            <>
              <div className="card">
                <a
                  href={`/starships/${starship.url.split("/")[5]}`}
                  key={starship.url.split("/")[5]}
                >
                  <Card sx={{ maxWidth: 345, borderRadius: 7, backgroundColor : "#111423", color : "#c0c2d9"}}>
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        height="140"
                        image="https://content.invisioncic.com/x311865/monthly_2022_06/HWC_Article_Header_HHR14_SWStarships_v1a.jpg.fbaf20672ce772a26f304014c5b99c9e.jpg"
                        alt={starship.name}
                        sx={{ borderRadius: 7 }}
                      />
                      <CardContent sx={{ textAlign: "center" }}>
                        <Typography gutterBottom variant="h5" component="div">
                          <strong>{starship.name}</strong>
                        </Typography>
                        <Typography variant="body2" color="text.primary" sx={{color : "#c0c2d9"}}>
                          <strong>Model:</strong> {starship.model}
                          <br />
                          <strong>Hyperdrive Rating:</strong> {starship.hyperdrive_rating}
                        </Typography>
                      </CardContent>
                    </CardActionArea>
                  </Card>
                </a>
              </div>
            </>
          ))}
       
        </div>}

        {starships.length === 0 && <p className="not-found">No Starships Found</p>}

      
        <div className="more-btn">
        {starships.length > loadedStarships && (
          <Button variant="contained" sx={{ backgroundColor: '#134e70', borderRadius: 7 }} onClick={loadMoreStarships}>
            Load More
          </Button>
        )}
        </div>
      </div>
    
    </>
  );
}

export default Starship;
