package com.yk.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUtil {

	private String IMGE_TYPE = ".jpg;.png;.jpeg;,icon";

	protected void service(HttpServletRequest req) throws ServletException,
			IOException {

		req.setCharacterEncoding("utf-8");
		// 解析检查请求，是否为multipart/form-data格式
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		if (!isMultipart) {
			return;
		}

		try {
			// 创建FileItemFactor对象
			// 根据fileitemfactor对象创建fileitem对象
			//
			DiskFileItemFactory fatactor = new DiskFileItemFactory();
			

			// 设置缓存大小
			// fatactor.setSizeThreshold(20 * 1024);
			// 设置临时目录
			// fatactor.setRepository(repository);

			// 创建文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(fatactor);
			
			upload.setFileSizeMax(1024*1024*2);

			// 解析请求
			List<FileItem> items = upload.parseRequest(req);

			for (FileItem fl : items) {

				if (fl.isFormField()) {
					System.out.println(fl.getFieldName() + ":"
							+ fl.getString("utf-8"));
				} else {
					String dir = req.getServletContext().getRealPath(
							"/resource/upload");
					String str = fl.getName();
					str = str.substring(str.lastIndexOf("."), str.length());

					String t = req.getServletContext()
							.getMimeType(fl.getName());
					System.out.println(t);// 上传文件类型（没有用到，先写下）
					

					String type[] = IMGE_TYPE.split(";");
					if (!Arrays.asList(type).contains(str)) {
						throw new LogicException("请上传正确的文件格式");
					}

					fl.write(new File(dir, UUID.randomUUID().toString() + str));
				}
			}

		}catch(FileSizeLimitExceededException e){
			throw new LogicException("文件太大了！");
		}
		catch (LogicException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
