package com.orznewbie.utils;

import com.orznewbie.entity.Chapter;
import com.orznewbie.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseVideoJson {
    List<Chapter> chapterList;
    List<List<Video>> videoList;
}
