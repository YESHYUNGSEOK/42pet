import { Link, Outlet } from "react-router-dom";
import styled from "styled-components";

const Layout = () => {
  return (
    <WrapperStyled>
      <BannerStyled>
        <BannerLeftSectionStyled>
          <img src="/src/assets/logo2.png" />
        </BannerLeftSectionStyled>
        <BannerRightSectionStyled>
          <img src="/src/assets/profile.jpg" />
        </BannerRightSectionStyled>
      </BannerStyled>
      <BodyStyled>
        <SubBannerStyled>
          <SubBannerLeftSectionStyled>
            <div>PETS SAVE THE WORLD!</div>
          </SubBannerLeftSectionStyled>
          <nav>
            <SubBannerCenterSectionStyled>
              <li>
                <Link to="main">Home</Link>
              </li>
              <li>
                <Link to="notice">Notice</Link>
              </li>
              <li>
                <Link to="profile">Profile</Link>
              </li>
            </SubBannerCenterSectionStyled>
          </nav>
          <SubBannerRightSectionStyled>
            <button>SEARCH</button>
            <img src="/src/assets/burger.png" />
          </SubBannerRightSectionStyled>
        </SubBannerStyled>
        <Outlet />
      </BodyStyled>
    </WrapperStyled>
  );
};

const WrapperStyled = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
  width: 100vw;
  background-image: linear-gradient(to bottom left, #bdbdbd, #f4e0c8);
  font-family: "Nunito Sans";
`;

const BannerStyled = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 8vh;
  width: 100vw;
`;

const BannerLeftSectionStyled = styled.div`
  display: flex;
  align-items: center;
  img {
    margin-left: -80px;
    margin-top: -40px;
    width: 300px;
  }
`;

const BannerRightSectionStyled = styled.div`
  display: flex;
  align-items: center;
  margin-right: 100px;
  img {
    width: 70px;
    border-radius: 100%;
  }
`;

const BodyStyled = styled.div`
  display: flex;
  flex-direction: column;
  height: 92vh;
  width: 90vw;
  background-color: #ffffff;
  border: 1px solid #929292;
`;

const SubBannerStyled = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 10vh;
  width: 90vw;
`;

const SubBannerLeftSectionStyled = styled.div`
  display: flex;
  align-items: center;
  div {
    margin-left: 50px;
    font-weight: bold;
  }
`;

const SubBannerCenterSectionStyled = styled.ul`
  display: flex;
  width: 300px;
  padding: 0;
  justify-content: space-between;
  list-style-type: none;
  font-weight: 500;
  * {
    color: black;
    text-decoration: none;
    margin: 0;
    padding: 0;
  }
`;

const SubBannerRightSectionStyled = styled.div`
  display: flex;
  align-items: center;
  margin-right: 50px;
  button {
    width: 200px;
    height: 40px;
    border-radius: 100px;
    background-color: #ffffff;
    font-family: "Nunito Sans";
  }
  img {
    margin-left: 20px;
    width: 25px;
  }
`;

export default Layout;
