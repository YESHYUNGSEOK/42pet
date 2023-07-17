import { atom } from "recoil";
import { IRightSectionContentInfo } from "../types/interface/right.section.interface";

export const isRightSectionOpenedState = atom<boolean>({
  key: "isRightSectionOpened",
  default: false,
});

export const rightSectionContentState = atom<IRightSectionContentInfo>({
  key: "rightSectionContent",
  default: {
    search: false,
    comment: false,
    follower: false,
    following: false,
    animalFilter: false,
  },
});